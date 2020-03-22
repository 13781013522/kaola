app.controller("baseController",function ($scope) {
    $scope.reloadList=function(){
        //切换页码
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    }

//分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();//重新加载
        }
    };

    $scope.selectIds=[];
    //判断复选框是否选中
    $scope.updateSelection=function ($event,id) {
        if ($event.target.checked){//判断true 和 false
            $scope.selectIds.push(id);
        }else {
            var idx=$scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx,1);//移除数组中指定位置的元素，第二个参数是移除几个
        }
    };


    //提取json字符串数据中某个属性，返回拼接字符串 逗号分隔
    $scope.jsonToString=function(jsonString,key){
        var json=JSON.parse(jsonString);//将json字符串转换为json对象
        var value="";
        for(var i=0;i<json.length;i++){
            if(i>0){
                value+=","
            }
            value+=json[i][key];
        }
        return value;
    };


});

