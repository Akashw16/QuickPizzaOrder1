import React from "react";
import { Link } from "react-router-dom";
import "../components/AdminDashboard.css";

const AdminDashboard = () => (
  <div className="dashboard-container">
    <h1>Welcome, Admin!</h1>
    <div className="actions">
      <Link to="/admin/orders" className="button">Manage Orders</Link>
      <Link to="/admin/pizzas" className="button">Manage Pizzas</Link>
    </div>
  </div>
);

export default AdminDashboard;
