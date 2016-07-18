package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.dao.JobDao;
import ro.teamnet.zth.appl.domain.Job;

import java.util.List;

/**
 * Created by Lorena on 7/15/2016.
 */
public class JobServiceImpl implements JobService{

    @Override
    public List<Job> findAllJobs() {
        JobDao jobDao = new JobDao();
        List<Job> jobList = jobDao.getAllJobs();

        return jobList;
    }

    @Override
    public Job findOneJob(String id) {

        JobDao jobDao = new JobDao();
        Job job = jobDao.getJobById(id);
        return job;
    }

    @Override
    public Job insert(Job job){

        JobDao jobDao = new JobDao();
        return jobDao.insertJob(job);

    }
}
