const rows = document.querySelectorAll("tbody tr");




        rows.forEach(row => {
            row.addEventListener('click', function() {
                const url = this.getAttribute('data-url'); 
                window.location.href = url;
            });
            row.style.cursor = "pointer";
        });