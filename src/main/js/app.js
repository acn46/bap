'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
// end::vars[]

const tableStyle={
		border: '1px solid black'
		}

const trStyle = {
		outline: 'thin solid',
		background : 'CCC'
}

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {
			bacterias: []
		};
	}

	componentDidMount() {
		client({method: 'GET', path: '/bap/bacterialist'}).done(response => {
			this.setState({bacterias: response.entity /* response.entity._embedded.bacterias */  });
		});
	}

	render() {
		return (
			<BacteriaList bacterias={this.state.bacterias}/>
		)
	}
}
// end::app[]

// tag::bacteria-list[]
class BacteriaList extends React.Component {
	render() {
		const bacterias = this.props.bacterias.map(bacteria =>
			<Bacteria /* key={bacteria._links.self.href} */ bacteria={bacteria}/>
		);
		return (
			<table style={tableStyle}>
				<tbody>
					<tr style={trStyle}>
						<th>Bacteria Id</th>
						<th>Bacteria Name</th>
						<th>Tax ID</th>
						<th>Lineage</th>
						<th>Count</th>
						<th>Proportion All</th>
						<th>Proportion Class</th>
					</tr>
					{bacterias}
				</tbody>
			</table>
		)
	}
}
// end::bacteria-list[]

// tag::bacteria[]
class Bacteria extends React.Component {
	render() {
		return (
			<tr style={trStyle}>
				<td>{this.props.bacteria.id}</td>
				<td>{this.props.bacteria.name}</td>
				<td>{this.props.bacteria.taxId}</td>
				<td>{this.props.bacteria.lineage}</td>
				<td>{this.props.bacteria.bacteriaCount}</td>
				<td>{this.props.bacteria.proportionAll}</td>
				<td>{this.props.bacteria.proportionClassified}</td>
			</tr>
		)
	}
}
// end::bacteria[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]

