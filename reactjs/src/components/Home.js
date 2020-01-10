import React, { Component } from 'react';
import '../App.css';
import NavBar from './NavBar.js';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
  render() {
    return (
      <div>
        <NavBar/>
        <Container fluid>
          <Button color="link"><Link to="/customers">See customer list</Link></Button>
        </Container>
      </div>
    );
  }
}

export default Home;