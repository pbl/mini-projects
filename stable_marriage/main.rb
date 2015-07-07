require_relative 'parser'
require_relative 'compare_output'

files = Dir.entries('./test_files')

files = (files.map {|filename| filename.split('.')[0]}).uniq
files.reject! { |filename| filename.nil? }

files.each do |filename|
  match = Parser.new("./test_files/#{filename}.in").run
  result = match.run
  correct_result = (CompareOutput.new).run(result, "./test_files/#{filename}.out")
  if correct_result
    puts "#{filename} was succesfully solved"
  else
    puts "#{filename} was not solved correctly"
  end
end
