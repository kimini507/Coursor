$(document).ready(function() {
  bindUserTabEvents();
  searchUser();

});

function bindUserTabEvents(){
  $("#SEARCH_USER").click(searchUser);
}

function searchUser(e){
  var json = {id: "2"}
  showLoadingCover($("#USER_LIST"));
  doAjaxRequest('get/user/list', {}, showUserList);  
}


function showUserList(userList){
  var $userRows = $("#USER_LIST tr");
  $userRows.remove();
  
  var userArray = [];
  for(var key in userList){
    var user = userList[key];
    var userdata = {
      name : user.lastName.toUpperCase() + ", " + user.firstName + " " + user.middleName,
      username : user.username,
      userrole : user.userRole[0].role.substring(5)
    }
    
    userArray.push(userdata);
  }
  
  var list = buildTemplate("userlist", {user:userArray});
  
  var $userTable = $("#USER_LIST");
  hideLoadingCover($userTable);
  
  $userTable.append(list);
  $("#USER_LIST tr div a").dotdotdot();
}
