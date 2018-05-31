mkdir -p data/mr-data
cd data/mr-data
wget https://raw.githubusercontent.com/yoonkim/CNN_sentence/master/rt-polarity.neg
wget https://raw.githubusercontent.com/yoonkim/CNN_sentence/master/rt-polarity.pos
cd ../..
mkdir -p data/glove
cd data/glove
wget http://nlp.stanford.edu/data/glove.6B.zip
unzip *.zip
cd ../..
