def fizz_buzz limit
  for i in 1..limit
    puts say i
  end
end

def say i 
  str = ''
  if(i % 3 == 0) then str += 'Fizz' end
  if(i % 5 == 0) then str += 'Buzz' end
  if(str.empty?) then str = i end
  str 
end

puts "Up to which number"
limit = gets.chomp
puts 'Result:'
fizz_buzz(limit.to_i)
