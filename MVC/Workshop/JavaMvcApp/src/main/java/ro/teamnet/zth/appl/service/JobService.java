package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.domain.Job;

import java.util.List;

/**
 * Created by Lorena on 7/15/2016.
 */
public interface JobService {

    public List<Job> findAllJobs();
    public Job findOneJob(String id);
    public Job insert(Job job);
}
