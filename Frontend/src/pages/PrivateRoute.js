import React from 'react';
import { Navigate } from 'react-router-dom';

const PrivateRoute = ({ children }) => {
  const isLoggedIn = true; // This should be dynamically set based on auth state

  return isLoggedIn ? children : <Navigate to="/login" />;
};

export default PrivateRoute;
