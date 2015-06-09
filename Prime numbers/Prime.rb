puts "How many primes?"
limit = gets.chomp.to_i - 1
puts 'Result:'
puts ''

primes = [2]
i = 3
while primes.length < limit
  if(!primes.any? {|p| i % p == 0})
    primes << i
  end
  i += 1
end
puts 1 
puts primes