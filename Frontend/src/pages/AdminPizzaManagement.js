import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AdminPizzaManagement = () => {
  const [pizzas, setPizzas] = useState([]);

  useEffect(() => {
    axios.get('/api/pizzas')  // Adjust the API endpoint
      .then(response => setPizzas(response.data))
      .catch(error => console.error('Error fetching pizzas:', error));
  }, []);

  return (
    <div>
      <h1>Pizza Management</h1>
      <ul>
        {pizzas.map(pizza => (
          <li key={pizza.id}>{pizza.name} - ${pizza.price}</li>
        ))}
      </ul>
    </div>
  );
}

export default AdminPizzaManagement;
