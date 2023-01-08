// login_page
function submitData() {
    const username = document.getElementById('companyName').value
    if (username !== null && username !== "" ) {
      storeUserDataInSession(username);
      window.location.replace('upload.html');
    }
}


  function storeUserDataInSession(companyName) {
    window.sessionStorage.setItem('companyName', JSON.stringify(companyName));
  }
