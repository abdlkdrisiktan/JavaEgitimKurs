var myAlbum = angular.module("ArtistProjectApp",[])
    .controller("AlbumController",function ($scope, $http) {

        $scope.album = {};
        $scope.albumList = [];

        $scope.pageOpen = function () {
            $scope.getAllAlbumList();
        };

        $scope.getAllAlbumList = function () {
            var res = $http.get('/album/getAllAlbumData')
            res.then(function (response) {
                $scope.albumList = response.data;
            })
        }

    });