require_relative 'word_graph'

class GraphBuilder
  def initialize dat_words
    @dat_words = dat_words
  end

  def build_graphs
    graphs = Hash.new
    @dat_words.each do |x|
      list = Array.new
      step = 0
      list[step] = [x]
      loop do
        connections = Array.new
        list[step].each do |word|
          new_words = find_connections(word)-list.flatten #only accept words which are new
          connections << new_words
        end
        step += 1
        list[step] = connections.flatten
        break if list[step].empty?
      end
      graphs[x] = list.slice(0..list.length-2)
    end
    graphs
  end

  def get_distance word, graph
    graph.each_with_index do |arr, i|
      found = arr.index word
      if !found.nil?
        return i
      end
    end
    return -1
  end

  private
    def find_connections word
      connections = Array.new
      @dat_words.each do |list_word|
        if !(list_word.eql? word)
          if connected?(word, list_word)
            connections << list_word
          end
        end
      end
      connections
    end

    def connected?(word, list_word)
      word = word.slice(1, word.length).split(//).sort
      list_word = list_word.split(//).sort
      missmatches = 0
      index = 0
      word.each do |char|
        if !(char.eql? list_word[index])
          missmatches += 1
          index += 1
          missmatches = (char.eql? list_word[index]) ? missmatches : missmatches+1
        end
        index += 1
        break if missmatches == 2
      end
      missmatches < 2
    end
end