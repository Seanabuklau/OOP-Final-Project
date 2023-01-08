// ensures user have to login to access page
if (window.sessionStorage.getItem('companyName') == null) {
  logOut();
}


function logOut() {
  sessionStorage.clear();
  location.href='landing_page.html';
}


const app = Vue.createApp({

    data() {
      return {
        companyName: '',
        SSOTfields: [],
        CUfields: [],
        currDragElement: null,
        mappings: [],
      };
    },
    created() {
    // ON PAGE LOAD: automatically get all ssot and cu fields and populate in html

      // get company name from session
      window.sessionStorage.getItem('companyName') ? this.companyName = JSON.parse(window.sessionStorage.getItem('companyName')) : this.companyName = '';
      console.log(this.companyName);

      // get all ssot field from server
      fetch('http://localhost:8080/api/SSOT', {
          method: 'GET'
        })
        .then(function(response) {
          return response.json();
        }).then((data) => {
          for (let i = 0; i < data.length; i++) {
            this.SSOTfields.push(data[i]['field']);
          }
        });

      // get all cu field from server
      fetch('http://localhost:8080/api/Company/getCompanyFields/' + this.companyName, {
          method: 'GET'
        })
        .then(function(response) {
          return response.json();
        }).then((data) => {
          for (let i = 0; i < data.length; i++) {
            // console.log(data[i]);
            this.CUfields.push(data[i]);
          }
        });


    },
    methods: {
      // methods for cu field dragging
      dragStart(cu) {
        this.currDragElement = document.getElementById(cu);
        setTimeout(() => {
          this.currDragElement.style.display = "none";
        }, 0);
        // console.log("dragStart");
      },
      dragEnd() {
        setTimeout(() => {
          this.currDragElement.style.display = "block";
          this.currDragElement = null;
        }, 0);
        // console.log("dragEnd");
      },


      // methods for mapped field dropped
      dragEnter(ssot) {
        var mappedSSOT = document.getElementById(ssot);
        mappedSSOT.style.border = "2px solid #ccc";
        // console.log("dragEnter");
      },
      dragOver(event) {
        event.preventDefault();
      },
      dragLeave(ssot) {
        var mappedSSOT = document.getElementById(ssot);
        mappedSSOT.style.border = "none";
        // console.log("dragLeave");
      },
      dragDrop(ssot) {
        var mappedSSOT = document.getElementById(ssot);
        mappedSSOT.style.border = "none";
        if (mappedSSOT.childNodes.length == 0) {
          mappedSSOT.appendChild(this.currDragElement);
        }
        // console.log("dropped");
      },


      // methods to handle user error when dragging and dropping
      dragDropRemoval() {
        document.getElementById('cu-section').appendChild(this.currDragElement);
      },


      // submit mapping
      submitMapping() {
        // get all mapped fields
        for (let i = 0; i < this.SSOTfields.length; i++) {
          var mappedSSOT = document.getElementById(this.SSOTfields[i]);
          if (mappedSSOT.childNodes.length > 0) {
            var mappedCU = mappedSSOT.childNodes[0].id;
            var eachMapping = {
              companyName: this.companyName,
              companyField: mappedCU,
              ssotField: this.SSOTfields[i]
            };
            this.mappings.push(eachMapping);
          }
        }
        // console.log(this.mappings);


        // send mappings to server
        fetch('http://localhost:8080/api/MappingCU', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(this.mappings)
          })
          .then(data => {
            console.log(data);
            if (data.ok) {
                document.getElementById("mapUploadCorrect").style.display = "block";
            }
        })
        .catch((err) => {
            console.log(err);
            document.getElementById("mapUploadWrong").style.display = "block";
        });

      }
    }
  });


  const vm = app.mount('#app');
