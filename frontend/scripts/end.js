//Remit more btn function
function remitMore(){
  window.location.replace('transactions.html');
  return false;
}

// ensures user have to login to access page
if (window.sessionStorage.getItem('companyName') == null) {
  logOut();
}

if (window.sessionStorage.getItem('fileName') == null) {
  location.href='transactions.html';
}


function logOut() {
    sessionStorage.clear();
    location.href='landing_page.html';
}


// Get company name from session
window.sessionStorage.getItem('companyName') ? companyName = JSON.parse(window.sessionStorage.getItem('companyName')) : companyName = '';
window.sessionStorage.getItem('fileName') ? fileName = JSON.parse(window.sessionStorage.getItem('fileName')) : fileName = '';
console.log(companyName);


// send transactions to server
console.log('Sending transaction to server')
const url = 'http://localhost:8080/api/transaction/send';

    let formBody = {
        "fileAndPath": fileName,
        "corporateName" : companyName,
        "username": "g2t1",
        "password": "techg@g2t1"
    }
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formBody)
        })
        .then(resp => resp.json())
        .then(data => {
        if (data.errors) {
            alert(data.errors)
        } else {
            alert("Transactions Sent!");


            // get transaction status from server
            var bodyjson = {
                "transactionIDs": data,
            }
            fetch('http://localhost:8080/api/transaction/all', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(bodyjson)
            })
            .then(function(response) {
                return response.json();
            })
            .then(function (data) {



                // dispplay transaction status in page
                var table_output = '<table class="txn-table">';
                table_output += '<thead><tr>' + '<th>Transaction ID</th>' + '<th>Status</th>' + '</tr></thead>';
                table_output += '<tbody>'
    
                for (var i = 0; i < data.length; i++){
                  table_output += '<tr><td>' + data[i]['transactionID'] + '</td>' + '<td>' + data[i]['status'] + '</td></tr>';
                }
    
                table_output += '</tbody></table>';
                document.getElementById('display-txn').innerHTML = table_output;
            });

        }
    });
