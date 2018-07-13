var myAlbum = angular.module("ArtistProjectApp",[])
    .controller("TrackController",function ($scope, $http) {


        $scope.track = {};
        $scope.trackList=[];


        $scope.pageOpen = function () {
           $scope.getAllTrackList();
           $scope.getAllAlbumList();
        };

        $scope.getAllTrackList = function () {
            var res = $http.get('/track/getAllTrackData');
            res.then(function (value) {
                $scope.trackList = value.data;
            })
        };

        $scope.save = function () {
            var res = $http.post('/track/saveTrackData',$scope.track);
            res.then(function (value) {
                alert(value.data);
                $scope.getAllTrackList();
            })
        };

        $scope.selectTrack= function (track) {
          $scope.track =track ;
        };

        $scope.getAllAlbumList = function () {
            var res = $http.get('/album/getAllAlbumData');
            res.then(function (response) {
                $scope.albumList = response.data;
            })
        };

        $scope.deleteTrackData= function (track) {
            $scope.track=track;
            var res = $http.post('/track/deleteTrackData',$scope.track)
            res.then(function (response) {
                $scope.track={};
                $scope.getAllTrackList();
            })
        };



    });