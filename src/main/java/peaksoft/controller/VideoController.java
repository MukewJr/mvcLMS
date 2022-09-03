package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Video;
import peaksoft.service.VideoService;

@Controller
@RequestMapping("/videos")
public class VideoController {

    private final VideoService service;

    @Autowired
    public VideoController(VideoService service) {
        this.service = service;
    }


    @GetMapping("/allVideos/{lessonId}")
    private String  getAllVideos(@PathVariable("lessonId")Long lessonId, Model model) {
        model.addAttribute("allVideos",service.getAllVideos(lessonId));
        model.addAttribute("lesson",lessonId);
        return "video/mainVideo";
    }

    @GetMapping("{lessonId}/newVideo")
    private String newVideo(@PathVariable("lessonId")Long id,Model model) {
        model.addAttribute("newVideo",new Video());
        model.addAttribute("lessonId",id);
        return "video/newVideo";
    }

    @PostMapping("{lessonId}/saveVideo")
    private String saveVideo(@PathVariable("lessonId")Long id, @ModelAttribute("newVideo")Video video) {
        service.saveVideo(id,video);
        return "redirect:/videos/allVideos/ "+id;
    }

    @GetMapping("/getVideo/{videoId}")
    private String getVideoById(@PathVariable("videoId")Long id,Model model) {
        model.addAttribute("video",service.getVideoById(id));
        return "video/mainVideo";
    }

    @GetMapping("/updateVideo/{videoId}")
    private String updateVideo(@PathVariable("videoId")Long id,Model model) {
        Video video = service.getVideoById(id);
        model.addAttribute("video",video);
        model.addAttribute("lessonId",video.getLesson().getLessonId());
        return "video/updateVideo";
    }

    @PostMapping("/{lessonId}/{videoId}/saveUpdateVideo")
    private String saveUpdateVideo(@PathVariable("lessonId")Long id,
                                   @PathVariable("videoId")Long videoId,
                                   @ModelAttribute("video")Video video) {
        service.updateVideo(videoId,video);
        return "redirect:/videos/allVideos/ " + id;
    }

    @PostMapping("/{lessonId}/{videoId}/deleteVideo")
    private String deleteVideo(@PathVariable("lessonId")Long id,@PathVariable("videoId")Long videoId) {
        service.deleteVideoById(videoId);
        return "redirect:/videos/allVideos/ " + id;
    }
}
