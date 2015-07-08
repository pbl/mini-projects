require_relative 'parser'
require_relative 'word_graph'
require_relative 'graph_builder'

parser = Parser.new './test_files/words-10'

dat_words = parser.get_dat
in_words = parser.get_in

graph_builder = GraphBuilder.new dat_words

graphs = graph_builder.build_graphs

in_words.each do |pair|
  puts "#{graph_builder.get_distance(pair[1], graphs[pair[0]])}"
end
