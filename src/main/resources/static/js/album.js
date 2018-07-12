var myAlbum = angular.module("ArtistProjectApp",[])
    .controller("AlbumController",function ($scope, $http) {

        $scope.album = {};
        $scope.albumList = [];


        $scope.pageOpen = function () {
            $scope.getAllAlbumList();
            $scope.getAllArtistList();
        };
        $scope.getAllAlbumList = function () {
            var res = $http.get('/album/getAllAlbumData')
            res.then(function (response) {
                $scope.albumList = response.data;
            })
        };
        $scope.save=function () {
            var res = $http.post('/album/saveAlbumData',$scope.album)
            res.then(function (response) {
                alert(response.data);
                $scope.getAllAlbumList();
            })
        };
        $scope.selectAlbum = function (album) {
            $scope.album =album;
            // $scope.album.artist = album.artist;
        };
        $scope.deleteAlbum= function (album) {
            $scope.album=album;
            var res = $http.post('/album/deleteAlbumData',$scope.album)
            res.then(function (response) {
                $scope.album={};
                $scope.getAllAlbumList()
            })

        };
        $scope.getAllArtistList= function () {
            var res = $http.get('/artist/getAllArtistData');
            res.then(function (value) {
              $scope.artistList= value.data;
            })

        }

    });