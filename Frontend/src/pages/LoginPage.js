import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../components/LoginPage.css";

const LoginPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();
    if (email === "admin@quickpizza.com" && password === "admin123") {
      navigate("/admin/dashboard");
    } else if (email.includes("@") && password.length >= 6) {
      navigate("/customer/dashboard");
    } else {
      setError("Invalid credentials. Please try again.");
    }
  };

  const handleSignUp = () => {
    navigate("/signup");
  };

  return (
    <div className="login-container anim-fade-in">
      <h1>Login</h1>
      <form onSubmit={handleLogin} className="anim-slide-up">
        {error && <p className="error">{error}</p>}
        <div>
          <label>Email</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Password</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="button">
          Login
        </button>
      </form>
      <div className="signup-link anim-slide-up">
        <p>
          Don't have an account? <button onClick={handleSignUp}>Sign Up</button>
        </p>
      </div>
    </div>
  );
};

export default LoginPage;
