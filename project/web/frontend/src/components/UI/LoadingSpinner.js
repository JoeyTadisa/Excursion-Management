import classes from "./LoadingSpinner.module.css";
/**
 *
 * @component LoadingSpinner shown when in loading state, friendly for a user
 */
const LoadingSpinner = () => {
  return <div className={classes.spinner}></div>;
};

export default LoadingSpinner;
