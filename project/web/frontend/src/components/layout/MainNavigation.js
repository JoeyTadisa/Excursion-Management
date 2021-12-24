//import { NavLink } from "react-router-dom";
import classes from "./MainNavigation.module.css";
import logo from "../UI/thu_logo.png";

const MainNavigation = () => {
  return (
    <header className={classes.header}>
      <img src={logo} className={classes.appLogo} alt="logo" />
      <h3 className={classes.logo}>Welcome to THU Excursions</h3>
    </header>
  );
};

export default MainNavigation;
