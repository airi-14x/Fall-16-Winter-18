function stats() {
   var wishToContinue = true;
   var num_even = 0;
   var num_odd = 0;
   var arr1 = [];

   while (wishToContinue) {
      var number = prompt("Please enter a number, enter -1 to quit");
      if (number == -1)
         wishToContinue = false;
      // If number isn't a number //
      if (isNaN(number) || number === '') {
         alert("Invalid Value. Ignored.");
      } else if (number != -1) {
         arr1.push(number);
      }
   }
   document.getElementById("statsOut").innerHTML += "You have entered below the mentioned numbers: </br>";
   for (var i = 0; i < arr1.length; i++) {
      document.getElementById("statsOut").innerHTML += arr1[i] + "</br>";
      //alert(arr1[i]);
      if (arr1[i] % 2 == 0)
         num_even++;
      else {
         num_odd++;
      }
   }

   document.getElementById("statsOut").innerHTML += "You have entered " + num_even + " even numbers and " + num_odd + " odd numbers.";

}
