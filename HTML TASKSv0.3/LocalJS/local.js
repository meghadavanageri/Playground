var ajaxRequest = new XMLHttpRequest();
ajaxRequest.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    var jsondata = JSON.parse(ajaxRequest.responseText);
    var info = jsondata.hits;

    var parent = document.getElementById('parent');
    var cont = document.createElement("div");
    parent.appendChild(cont);

  for(i=0;i<info.length;i++){

  var card=document.createElement("div");
  cont.appendChild(card);
  cont.style="background:#FFFFF;";
  card.style="border:1px solid black;padding:0.5%";

  var image = document.createElement("img");
  card.appendChild(image);
  image.src= info[i].webformatURL;
  image.style="width:150px;";
  image.style="width:150px;float:left;width:10%;padding:1%";

  
  var text = document.createElement("div");
  card.appendChild(text);
  text.innerHTML = info[i].tags;
  text.style="clear:both;margin-left:15%";

  
  var button = document.createElement("div");
  card.appendChild(button);
  button.id="btn";
  button.innerHTML="Details"
  button.style="width:10%;border:1px solid black;text-align: center;";
  button.onclick= function myFunction(){
   window.location.replace("localnext.html");
  }
 
}
}
  };

   ajaxRequest.open(
    "GET","Movielocal.json",true
  );
  ajaxRequest.send();
