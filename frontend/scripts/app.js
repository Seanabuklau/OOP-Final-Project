// login_page
function submitData() {
  const username = document.getElementById('username').value
  if (username !== null && username !== "" ) {
    storeUserDataInSession(username);
    window.location.replace('transactions.html')
  }
}

function storeUserDataInSession(companyName) {
  window.sessionStorage.setItem('companyName', JSON.stringify(companyName));
}
