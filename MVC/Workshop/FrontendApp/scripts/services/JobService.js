'use strict';

hrApp.service('JobService', ['$http', 'CommonResourcesFactory', function($http, CommonResourcesFactory) {
    return {
        findAll: function() {
            return $http.get(CommonResourcesFactory.findAllJobsUrl)
                .success(function(data) {
                    return data;
                }).error(function(data) {
                    return data;
            });
        },
        findOne: function(id) {
            return $http.get(CommonResourcesFactory.findOneJobUrl , {params: {id: id}})
                .success(function(data) {
                    return data;
                }).error(function(data) {
                    return data;
                });
        },
        add: function(job) {
            return $http.post(CommonResourcesFactory.addJobUrl, job)
                .success(function(data) {
                    return data;
                })
                .error(function(data) {
                    return data;
                });
        },
        edit: function(id) {
            return $http.put(CommonResourcesFactory.editJobUrl,{params: {id: job.id ,
            title: job.jobTitle,
            mins: job.minSalary,
            maxs: job.maxSalary}})
                .success(function(data) {
                    return data;
                })
                .error(function(data) {
                    return data;
                });
        },
        delete: function(id) {
            return $http.delete(CommonResourcesFactory.deleteJobUrl  , {params: {id: id}})
                .success(function(data) {
                    return data;
                })
                .error(function(data) {
                    return data;
                });
        }
    }
}]);