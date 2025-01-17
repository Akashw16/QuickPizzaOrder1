import React from 'react';

const OrderPage = () => {
  return (
    <div>
      <h1>Place Your Order</h1>
      <form>
        <input type="text" placeholder="Customer Name" />
        <input type="text" placeholder="Delivery Address" />
        <button type="submit">Submit Order</button>
      </form>
    </div>
  );
};

export default OrderPage;
