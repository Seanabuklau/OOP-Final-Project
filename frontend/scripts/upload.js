// ensures user have to login to access page
if (window.sessionStorage.getItem('companyName') == null) {
    logOut();
}
  

// onboarding upload page to get company headers
function logOut() {
    sessionStorage.clear();
    location.href='landing_page.html';
}

// Get company name from session
window.sessionStorage.getItem('companyName') ? companyName = JSON.parse(window.sessionStorage.getItem('companyName')) : companyName = '';
console.log(companyName);


// Sending upload file to SpringBoot server
// server will extract company headers
// redirect users to mapping page if successful
const uploadForm = document.querySelector('.upload_form')
uploadForm.addEventListener("submit", async function(e) {
    e.preventDefault()
    let file = e.target.uploadFile.files[0]
    let formData = new FormData()
    formData.append('file', file)
    formData.append('companyName', companyName)

    fetch('http://localhost:8080/uploadFile', {
        method: 'POST',
        body: formData
    })
        .then(data => {
            console.log(data);
            window.location = "mapping.html";
        })
        .catch((err) => {
            console.log(err);
            document.getElementById("fileUploadAlert").style.display = "block";
        });
});

