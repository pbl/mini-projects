require_relative '../woman'

describe 'Woman' do
  before :each do
      @woman = Woman.new [1, 3, 5]
  end

  it 'accepts if she is single' do
    @woman.propose(3).should eql 0
  end

  it 'accepts the man proposing has higher prio' do
    @woman.propose(3).should eql 0
    @woman.propose(1).should eql 3
  end

  it 'rejects the man proposing has lower prio' do
    @woman.propose(3).should eql 0
    @woman.propose(5).should eql -1
  end
end