
// A message useful when a device try to execute the app and there is no permutation for it.
alert("Undefined permutation for this device.\n" 
    + window.navigator.userAgent.toLowerCase() + " " + window.devicePixelRatio);
