package ro.teamnet.zth.appl.controller;

import jdk.nashorn.internal.scripts.JO;
import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.appl.dao.JobDao;
import ro.teamnet.zth.appl.domain.Job;
import ro.teamnet.zth.appl.service.JobService;
import ro.teamnet.zth.appl.service.JobServiceImpl;

import java.util.List;

/**
 * Created by Lorena on 7/15/2016.
 */

@MyController(urlPath = "/jobs")
public class JobController {

    @MyRequestMethod(urlPath = "/all")
    public List<Job> getAllJobs() {
        JobService jobService = new JobServiceImpl();
        List<Job> jobList = jobService.findAllJobs();
        return jobList;

    }


    @MyRequestMethod(urlPath = "/one")
    public Job getOneJob(@MyRequestParam(name = "id") String id) {

        JobService jobService = new JobServiceImpl();
        Job job = jobService.findOneJob(id);

        return job;
    }

    @MyRequestMethod(urlPath = "/one" ,methodType = "DELETE")
    public void deleteOneJob(@MyRequestParam(name = "id") String id){

         Job job = getOneJob(id);
        JobDao jobDao = new JobDao();
        jobDao.deleteJob(job);

    }

    @MyRequestMethod(urlPath ="/insert",methodType = "POST")
    public Job SaveLocation(@MyRequestParam(name = "title") String title, @MyRequestParam(name = "maxs") int maxs, @MyRequestParam(name = "mins") int mins){
        Job job=new Job();
        job.setJobTitle(title);
        job.setMaxSalary(maxs);
        job.setMinSalary(mins);
        JobService jobService = new JobServiceImpl();
        return jobService.insert(job);
    }




}