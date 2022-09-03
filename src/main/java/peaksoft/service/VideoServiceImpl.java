package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.TaskDao;
import peaksoft.dao.VideoDao;
import peaksoft.entity.Video;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService{
    private VideoDao videoDao;

    @Autowired
    public VideoServiceImpl(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    @Override
    public void saveVideo(Long lessonId, Video video) {
        videoDao.saveVideo(lessonId, video);
    }

    @Override
    public void updateVideo(Long id, Video video) {
      videoDao.updateVideo(id, video);
    }

    @Override
    public Video getVideoById(Long id) {
        return videoDao.getVideoById(id);
    }

    @Override
    public List<Video> getAllVideos(Long id) {
        return videoDao.getAllVideos(id);
    }

    @Override
    public void deleteVideoById(Long id) {
      videoDao.deleteVideoById(id);
    }
}
