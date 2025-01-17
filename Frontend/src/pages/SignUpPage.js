import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../components/SignUpPage.css";

const SignUpPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleSignUp = (e) => {
    e.preventDefault();
    // Simulate successful signup
    navigate("/login");
  };

  return (
    <div className="signup-container anim-fade-in">
      <h1>Sign Up</h1>
      <form onSubmit={handleSignUp} className="anim-slide-up">
        <div>
          <label>Email</label>
          <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
        </div>
        <div>
          <label>Password</label>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
        </div>
        <button type="submit" className="button">Sign Up</button>
      </form>
    </div>
  );
};

export default SignUpPage;
