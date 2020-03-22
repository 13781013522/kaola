app.controller("brandController",function ($scope,$http,$controller,brandService,$http) {
    $controller('baseController',{$scope:$scope})
    $scope.findAll=function () {
        //查询全部
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        )
    }

    //查询分页
    $scope.findPage=function (page,rows) {
       brandService.findPage(page,rows).success(
            function (response) {
                $scope.paginationConf.totalItems=response.total; //总条数
                $scope.list=response.rows;
            }
        )
    }
    //保存
    $scope.save=function () {
        //判断
        var method=null;
        var obj = null;
        if ($scope.entity.id==null){
            obj = brandService.save($scope.entity);
        } else {
            obj = brandService.update($scope.entity);
        }

       obj.success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();
                }else {
                    alert(response.message);
                }
            }
        )
    }
    //查询单条
    $scope.findOne=function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity=response;
            }
        )
    }



    //搜索
    $scope.searchEntity={};
    $scope.search=function (page,rows) {
        brandService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.paginationConf.totalItems=response.total; //总条数
                $scope.list=response.rows;
            }
        )
    }


    //删除
    $scope.dele=function () {
        brandService.dele($scope.selectIds).success(
            function (response) {
                if (response.success){
                    $scope.reloadList();
                }else {
                    alert("删除失败");
                }
            }
        )
    }




})
