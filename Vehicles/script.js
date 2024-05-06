$(document).ready(function() {
    $('#vehicleForm').on('submit', function(event) {
      event.preventDefault();
  
      const plateNumber = $('#plateNumber').val();
      const make = $('#make').val();
      const model = $('#model').val();
      const latitude = $('#latitude').val();
      const longitude = $('#longitude').val();
  
      $.ajax({
        url: '/vehicles',
        method: 'POST',
        data: {
          plateNumber,
          make,
          model,
          latitude,
          longitude
        }
      }).done(function() {
        alert('Vehicle registered successfully!');
      }).fail(function() {
        alert('Error registering vehicle. Please try again.');
      });
    });
  
    function displayVehiclesOnMap() {
      $.get('/vehicles', function(data) {
        const vehicles = data.vehicles; 
        const map = L.map('mapContainer').setView([0, 0], 1);
  
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
          attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(map);
  
        for (const vehicle of vehicles) {
          const marker = L.marker([vehicle.latitude, vehicle.longitude]).addTo(map);
        }
      });
    }
  });