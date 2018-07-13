var myFollower = angular.module("ArtistProjectApp", [])
    .controller("FollowerController", function ($scope, $http) {

        $scope.follower = {};
        $scope.followerList = [];

        $scope.pageOpen = function () {
            $scope.getAllFollowerList();
        };

        $scope.getAllFollowerList = function () {
            var res = $http.get('follower/getAllFollowerData');
            res.then(function (value) {
                $scope.followerList = value.data;
            })
        };

        $scope.save = function () {
            var res = $http.post('follower/followAlbumDataByFollower', $scope.album);
            res.then(function (value) {
                alert(value.data);
                $scope.getAllFollowerList();
            })
        }

        $scope.selectFollower = function (follower) {
            $scope.follower = follower;
            var res =

        }

    });