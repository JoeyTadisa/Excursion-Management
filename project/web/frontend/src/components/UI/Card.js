import "./Card.css";
/**
 * @component
 * @param {*} props
 */
const Card = (props) => {
  const classes = "card " + props.className;
  return <div className={classes}>{props.children}</div>;
};

// const Card = (props) => {
//   return <div className={classes.card}>{props.children}</div>;
// };

export default Card;
