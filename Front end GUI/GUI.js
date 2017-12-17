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
  //converts based on currency
  function convert(){
    var priceDisp = price.innerHTML.value;
    var selection = document.getElementsByClassName('cur').value;
    var fill = document.getElementsByClassName('convert');
    if (selection.value == "GBP"){
      fill.innerHTML = priceDisp.value * 10;
    }
    if (selection.value == "USD"){
      fill.innerHTML = priceDisp.value * 12;

  }
  if (selection.value == "UAE"){
    fill.innerHTML = priceDisp.value * 14;
}

}
}
