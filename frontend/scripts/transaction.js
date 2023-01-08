// ensures user have to login to access page
if (window.sessionStorage.getItem('companyName') === null) {
  logOut();
}

function logOut() {
  sessionStorage.clear();
  location.href='landing_page.html';
}

// Get company name from session
window.sessionStorage.getItem('companyName') ? companyName = JSON.parse(window.sessionStorage.getItem('companyName')) : companyName = '';
console.log(companyName);

//Reading transaction files and displaying each transaction in a table
const excel_file = document.getElementById('excel_file');
excel_file.addEventListener('change', (event) => {

  // upload transaction file in data folder
  var file = document.getElementsByClassName('transactionsForm')[0].excelFile.files[0];
  let formData = new FormData()
  formData.append('file', file)
  fetch('http://localhost:8080/uploadTransactionFile', {
    method: 'POST',
    body: formData
  })
  .then((data) => {
    console.log(data);
  })
  .catch((err) => {
    console.log(err);
  });

  // get ssot headers matching transaction headers
  fileName = "data/" + file.name;
  var bodyjson = {
    "fileAndPath": fileName,
    "corporateName" : companyName
  }

  fetch('http://localhost:8080/api/transaction/header', {
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
    var ssotHeaders = data;
    // calls display transaction excel as table in page
    displayTransactionExcel(ssotHeaders, file);
  });
});

// display transaction as excel in page
function displayTransactionExcel(ssotHeaders, file) {
    if (!['application/vnd.openxmlformats-officedocument.spreadsheetml.sheet', 'application/vnd.ms-excel'].includes(file.type)) {
      document.getElementById('excel_data').innerHTML = '<div class="alert alert-danger">Only .xlsx or .xls file format are allowed</div>';
      excel_file.value = '';
      return false;
    }
    var reader = new FileReader();
    reader.readAsArrayBuffer(file);
    reader.onload = function(event) {
      var data = new Uint8Array(reader.result);
      var work_book = XLSX.read(data, {
        type: 'array'
      });
      var sheet_name = work_book.SheetNames;
      var sheet_data = XLSX.utils.sheet_to_json(work_book.Sheets[sheet_name[0]], {
        header: 1
      });
      if (sheet_data.length > 0) {
        var table_output = '<table class="table table-striped table-bordered">';

        // Get ssot headers to populate in table

        for (var i = 0; i < ssotHeaders.length; i++){
          table_output += '<th bgcolor="yellow">' + ssotHeaders[i] + '</th>';
        }

        for (var row = 0; row < sheet_data.length; row++) {
          table_output += '<tr>';
          for (var cell = 0; cell < sheet_data[row].length; cell++) {
            if (row == 0) {
              table_output += '<th>' + sheet_data[row][cell] + '</th>';
            } else {
              table_output += '<td>' + sheet_data[row][cell] + '</td>';
            }
          }
          table_output += '</tr>';
        }
        table_output += '</table>';
        document.getElementById('excel_data').innerHTML = table_output;
      }
      excel_file.value = '';
    }
}


// submit transactions after submit button is clicked
function submitTransaction() {
  // redirect to transaction status page
  window.sessionStorage.setItem('fileName', JSON.stringify(fileName));
  window.location.replace('end.html');
}
