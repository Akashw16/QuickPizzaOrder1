import React from "react";
import "../components/CartPage.css";

const CartPage = () => {
  const cartItems = []; // Replace with actual data source

  return (
    <div className="cart-container">
      <h2 className="cart-title">Your Cart</h2>
      {cartItems.length > 0 ? (
        <div className="cart-items">
          {cartItems.map((item, index) => (
            <div className="cart-item" key={index}>
              <h3>{item.name}</h3>
              <p>{item.description}</p>
              <span>${item.price}</span>
            </div>
          ))}
        </div>
      ) : (
        <p className="cart-empty">Your cart is empty!</p>
      )}
    </div>
  );
};

export default CartPage;
