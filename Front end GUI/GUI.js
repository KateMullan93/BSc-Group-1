window.onload = function(){

  // displays departure airport
  function displayDeparture(){
  var flyTO = document.getElementsByClassName('from');
  var flyDepart = document.getElementById('dept');
  flyDepart.onchange = function(){
    flyTO.innerHTML = flyDepart.value;
  }
}

  //displays destination airport
  function displayDestination(){
  var flyFrom = document.getElementsByClassName('to');
  var flyDest = document.getElementById('dest');
  flyDest.onchange = function(){
    flyFrom.innerHTML = flyDest.value;
  }
}
  //applies conversation based on currency
  function conversation(){
    var price = flyTO.innerHTML.value;
    var fill = document.getElementsByClassName('convert');
    fill.innerHTML = price.value;
  }






}
