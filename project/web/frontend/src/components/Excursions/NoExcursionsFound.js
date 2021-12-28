import { Link } from "react-router-dom";
import classes from "./NoExcursionsFound.module.css";

const NoExcursionsFound = () => {
  return (
    <div className={classes.noexcursions}>
      <p>No excursions found!</p>
      <Link className="btn" to="new-excursion">
        Add an Excursion
      </Link>
    </div>
  );
};

export default NoExcursionsFound;
