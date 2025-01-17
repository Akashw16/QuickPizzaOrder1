import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AdminOrderManagement = () => {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    axios.get('/api/orders')  // Adjust the API endpoint
      .then(response => setOrders(response.data))
      .catch(error => console.error('Error fetching orders:', error));
  }, []);

  return (
    <div>
      <h1>Order Management</h1>
      <ul>
        {orders.map(order => (
          <li key={order.id}>
            {order.customerName} - {order.status}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default AdminOrderManagement;
