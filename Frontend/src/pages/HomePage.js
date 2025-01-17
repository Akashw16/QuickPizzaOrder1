import React from "react";
import { useNavigate } from "react-router-dom";
import "../components/HomePage.css";

const HomePage = () => {
  const navigate = useNavigate();

  const handleOrderPizza = () => {
    navigate("/order-pizza");
  };

  const handleViewCart = () => {
    navigate("/cart");
  };

  const handleLogin = () => {
    navigate("/login");
  };

  return (
    <div className="home-container">
      <video
        autoPlay
        loop
        muted
        className="background-video"
      >
        <source src="/videos/background.mp4" type="video/mp4" />
        Your browser does not support the video tag.
      </video>

      <div className="black-overlay"></div>

      <div className="home-content">
        <h1 className="home-title">Welcome to QuickPizza</h1>
        <div className="home-buttons">
          <button className="home-button" onClick={handleOrderPizza}>
            Order Pizza
          </button>
          <button className="home-button" onClick={handleViewCart}>
            View Cart
          </button>
          <button className="home-button" onClick={handleLogin}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
};

export default HomePage;
