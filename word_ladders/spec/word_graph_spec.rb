require_relative '../word_graph'
require_relative '../parser'

describe 'WordGraph' do
  before :each do
    words = ['there', 'other', 'rando', 'andor', 'dorna', 'rrndo', 'rndor', 'dornr']
    @word_graph = WordGraph.new words
  end

  it 'finds correct edge' do
    connections = @word_graph.find_connections 'other'
    expect(connections.length).to eq(1)
    expect(connections[0]).to eq('there')
  end

  it 'finds correct edge for several' do
    connections = @word_graph.find_connections 'rando'
    expect(connections.length).to eq(2)
    expect(connections).to eq(['andor', 'dorna'])
  end

  it 'finds correct edge for duplicate letter' do
    connections = @word_graph.find_connections 'rrndo'
    expect(connections.length).to eq(5)
    expect(connections).to eq(['rando', 'andor', 'dorna', 'rndor', 'dornr'])
  end

  it 'returns empty array when there is no connection' do
    connections = @word_graph.find_connections 'there'
    expect(connections.length).to eq(0)
  end
end