import { Link } from "react-router-dom";
import classes from "./NoExcursionsFound.module.css";

/**
 * if there is no excursions this component is shown,
 * able to redirect to NewExcursion component
 * @component NoExcursionsFound
 */
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
