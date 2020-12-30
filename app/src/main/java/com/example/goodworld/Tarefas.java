package com.example.goodworld;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Tarefas extends AppCompatActivity {
    public Date nova = null;
    private TextView motiva,objetivo,reflexcao;
    //private Button inicia;
    //public String b;
    //public String a;
    //Mapear a TextView com a variavel texto
    //public TextView texto;


    private Button suporteme;
    private Button voltar;
    private Button btntarefa;
    int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefas);

        //nova = datadehoje();

        motiva = (TextView) findViewById(R.id.textMotiva);
        objetivo=(TextView) findViewById(R.id.textObjetivo);
        reflexcao=(TextView) findViewById(R.id.textReflex);


        suporteme = findViewById(R.id.btnapoieme);
        images =new int[]{R.drawable.botao2,R.drawable.botao};
        voltar = findViewById(R.id.btnsair3);

        btntarefa =findViewById(R.id.btntarefa);




    }

    public void btninicia(View view)
    {
        //Arrays das frases
        String[] frasesMotiva = {
                "\"Problems are opportunities to show what you know.\"  \n Duke Ellington",
                "\"Our failures are sometimes more fruitful than successes.\" \n Henry Ford",
                "\"Try again. Fail again. But fail better ”.\n Samuel Beckett",
                " \"It is the custom of a fool, when he makes mistakes, to complain about others. It is the custom of a wise man to complain about himself.\" \n Socrates",
                "\"True heroism consists in persisting for another moment, when everything seems lost.\"  \n W. F. Grenfel",
                "\"Not every day is good, but there is something good every day.\" \n Anonymous",
                "\"If you want to achieve greatness stop asking for permission.\" \n Anonymous",
                "\"Things work out best for those who make the best of how things work out.\" \n John Wooden",
                "\"To live a creative life, we must lose our fear of being wrong.\" \n Anonymous",
                "\"If you are not willing to risk the usual you will have to settle for the ordinary.\" \n Jim Rohn",
                "\"Trust because you are willing to accept the risk, not because it's safe or certain.\" \n Anonymous",
                "\"All our dreams can come true if we have the courage to pursue them.\" \n Walt Disney",
                "\"Good things come to people who wait, but better things come to those who go out and get them.\" \n Anonymous",
                "\"If you do what you always did, you will get what you always got.\" \n Anonymous",
                "\"Success is walking from failure to failure with no loss of enthusiasm.\" \n Winston Churchill",
                "\"Just when the caterpillar thought the world was ending, he turned into a butterfly.\" \n Proverb",
                "\"Successful entrepreneurs are givers and not takers of positive energy.\" \n Anonymous",
                "\"Whenever you see a successful person you only see the public glories, never the private sacrifices to reach them.\" \n Vaibhav Shah",
                "\"Opportunities don't happen, you create them.\" \n Chris Grosser",
                "\"Try not to become a person of success, but rather try to become a person of value.\" \n Albert Einstein",
                "\"Great minds discuss ideas; average minds discuss events; small minds discuss people.\" \n Eleanor Roosevelt",
                "\"I have not failed. I've just found 10,000 ways that won't work.\" \n Thomas A. Edison",
                "\"If you don't value your time, neither will others. Stop giving away your time and talents--start charging for it.\" \n Kim Garst",
                "\"A successful man is one who can lay a firm foundation with the bricks others have thrown at him.\" \n David Brinkley",
                "\"No one can make you feel inferior without your consent.\" \n Eleonor Roosevelt",
                "\"The whole secret of a successful life is to find out what is one's destiny to do, and then do it.\" \n Henry Ford",
                "\"If you're going through hell keep going.\" \n Winston Churchill",
                "\"The ones who are crazy enough to think they can change the world, are the ones who do.\" \n Anonymous",
                "\"Don't raise your voice, improve your argument.\" \n Anonymous",
                "\"What seems to us as bitter trials are often blessings in disguise.\" \n Oscar Wilde",
                "\"The meaning of life is to find your gift. The purpose of life is to give it away.\"  \n Anonymous",
                "\"The distance between insanity and genius is measured only by success.\" \n Bruce Feirstein",
                "\"When you stop chasing the wrong things, you give the right things a chance to catch you.\" \n Lolly Daskal",
                "\"I believe that the only courage anybody ever needs is the courage to follow your own dreams.\" \n Oprah Winfrey",
                "\"No masterpiece was ever created by a lazy artist.\" \n Anonymous",
                "\"If you can't explain it simply, you don't understand it well enough.\" \n Albert Einstein",
                "\"Blessed are those who can give without remembering and take without forgetting.\" \n Anonymous",
                "\"Do one thing every day that scares you.\" \n Anonymous",
                "\"What's the point of being alive if you don't at least try to do something remarkable.\" \n Anonymous",
                "\"Life is not about finding yourself. Life is about creating yourself.\" \n Lolly Daskal",
                "\"Nothing in the world is more common than unsuccessful people with talent.\" \n Anonymous",
                "\"Knowledge is being aware of what you can do. Wisdom is knowing when not to do it.\" \n Anonymous",
                "\"Your problem isn't the problem. Your reaction is the problem.\" \n Anonymous",
                "\"You can do anything, but not everything.\" \n Anonymous ",
                "\"Innovation distinguishes between a leader and a follower.\" \n Steve Jobs",
                "\"I find that the harder I work, the more luck I seem to have.\" \n Thomas Jefferson",
                "\"The starting point of all achievement is desire.\" \n Napoleon Hill",
                "\"Success is the sum of small efforts, repeated day-in and day-out.\" \n Robert Collier",
                "\"All progress takes place outside the comfort zone.\" \n Michael John Bobak",
                "\"You may only succeed if you desire succeeding; you may only fail if you do not mind failing.\" \n Philippos",
                "\"Courage is resistance to fear, mastery of fear--not absence of fear.\" \n Mark Twain",
                "\"Only put off until tomorrow what you are willing to die having left undone.\" \n Pablo Picasso",
                "\"We become what we think about most of the time, and that's the strangest secret.\" \n Earl Nightingale",
                "\"The only place where success comes before work is in the dictionary.\" \n Vidal Sassoon",
                "\"Too many of us are not living our dreams because we are living our fears. \" \n Les Brown",
                "\"It's not what you look at that matters, it's what you see.\" \n Anonymous",
                "\"The road to success and the road to failure are almost exactly the same.\" \n Colin R. Davis",
                "\"The function of leadership is to produce more leaders, not more followers.\" \n Ralph Nader",
                "\"Success is liking yourself, liking what you do, and liking how you do it.\" \n Maya Angelou",
                "\"As we look ahead into the next century, leaders will be those who empower others.\"  \n Bill Gates",
                "\"A real entrepreneur is somebody who has no safety net underneath them.\" \n Henry Kravis",
                "\"The successful warrior is the average man, with laser-like focus.\" \n Bruce Lee",
                "\"There is no traffic jam along the extra mile.\" \n Roger Staubach",
                "\"Don't let the fear of losing be greater than the excitement of winning.\" \n Robert Kiyosaki",
                "\"The number one reason people fail in life is because they listen to their friends, family, and neighbors.\" \n Napoleon Hill",
                "\"Success does not consist in never making mistakes but in never making the same one a second time.\" \n George Bernard Shaw",
                "\"You must expect great things of yourself before you can do them.\" \n Michael Jordan",
                "\"Motivation is what gets you started. Habit is what keeps you going.\" \n Jim Ryun",
                "\"People rarely succeed unless they have fun in what they are doing.\" \n Dale Carnegie",
                "\"A goal is not always meant to be reached; it often serves simply as something to aim at.\" \n Bruce Lee",
                "\"Be miserable. Or motivate yourself. Whatever has to be done, it's always your choice.\" \n Wayne Dyer",
                "\"What would you do if you weren't afraid.\" \n Spencer Johnson",
                "\"Failure is the condiment that gives success its flavor.\"  \n Truman Capote",
                "\"Don't let what you cannot do interfere with what you can do.\" \n John R. Wooden",
                "\"You may have to fight a battle more than once to win it.\" \n Margaret Thatcher",
                "\"People often say that motivation doesn't last. Well, neither does bathing -- that's why we recommend it daily.\" \n Zig Ziglar",
                "\"Someday is not a day of the week.\" \n Denise Brennan-Nelson",
                "\"Hire character. Train skill.\" \n Peter Schutz",
                "\"Your time is limited, so don't waste it living someone else's life.\" \n Steve Jobs",
                "\"Everyone lives by selling something.\" \n Robert Louis Stevenson",
                "\"If you are not taking care of your customer, your competitor will.\" \n Bob Hooey",
                "\"If you cannot do great things, do small things in a great way.\" \n Napoleon Hill",
                "Without a customer, you don't have a business -- all you have is a hobby.\" \n Don Peppers",
                "\"I'd rather regret the things I've done than regret the things I haven't done.\" \n Lucille Ball",
                "\"I didn't get there by wishing for it or hoping for it, but by working for it.\" \n Estée Lauder",
                "\"Always do your best. What you plant now, you will harvest later.\" \n Og Mandino",
                "\"Energy and persistence conquer all things.\"  \n Benjamin Franklin",
                "\"Formula for success: rise early, work hard, strike oil.\" \n J. Paul Getty",
                "\"Don't ask if your dream is crazy, ask if it's crazy enough.\" \n Lena Waithe",
                "\"The act of doing something un-does the fear.\" \n Shonda Rhimes",
                "\"Be poor, humble and driven (PhD). Don't be afraid to shift or pivot.\" \n Alex Rodriguez",
                "\"#1 make good decisions, #2 everything else.\" \n Rand Fishkin",
                "\" Life is about making an impact, not making an income.\" \n Kevin Kruse",
                "\"Whatever the mind of man can conceive and believe, it can achieve.\" \n Napoleon Hill",
                "\"Strive not to be a success, but rather to be of value.\" \n Albert Einstein",
                "\"You miss 100% of the shots you don’t take.\" \n Wayne Gretzky",
                "\"Every strike brings me closer to the next home run.\" \n Babe Ruth",
                "\"We become what we think about.\" \n Earl Nightingale",
                "\"Life is 10% what happens to me and 90% of how I react to it.\" \n Charles Swindoll",
                "\"The mind is everything. What you think you become. \" \n Buddha",
                "\"An unexamined life is not worth living.\" \n Socrates",
                "\"Eighty percent of success is showing up.\" \n Woody Allen",
                "\" Your time is limited, so don’t waste it living someone else’s life.\" \n Steve Jobs",
                "\"Winning isn’t everything, but wanting to win is.\" \n Vince Lombardi",
                "Teach thy tongue to say, \"I do not know,\" and thous shalt progress. \" \n Maimonides",
                "\"Start where you are. Use what you have.  Do what you can.\" \n ",
                "\"Fall seven times and stand up eight. \" \n Japanese Proverb",
                "\"Everything has beauty, but not everyone can see.\" \n Confucius",
                "\"When I let go of what I am, I become what I might be.\" \n Lao Tzu",
                "\"Happiness is not something readymade.  It comes from your own actions.\" \n Dalai Lama",
                "\"If the wind will not serve, take to the oars.\" \n Latin Proverb",
                "\" There are no traffic jams along the extra mile.\" \n Roger Staubach",
                "\"It is never too late to be what you might have been. \" \n George Eliot",
                "\"You become what you believe.\" \n Oprah Winfrey",
                "\"I would rather die of passion than of boredom.\" \n Vincent van Gogh ",
                "\" Dream big and dare to fail. \" \n Norman Vaughan ",
                "\"Dreaming, after all, is a form of planning.\" \n Gloria Steinem",
                "\"Life is what we make it, always has been, always will be. \" \n Grandma Moses",
                "\"Nothing is impossible, the word itself says, \"I’m possible!\"\" \n Audrey Hepburn",
                "\"The only way to do great work is to love what you do.\" \n Steve Jobs",
                "\" If you can dream it, you can achieve it. \" \n Zig Ziglar"

        };

        String[] frasesObjetivo=
        {
                "Keep a gratitude journal.",
                "Reframe your challenges.",
                "Get good at being rejected.",
                "Use positive words to describe your life.",
                "Replace have with get.",
                "Don’t let yourself get dragged into other people’s complaints.",
                "Breathe.",
                "Notice the righteous in times of tragedy.",
                "Have solutions when pointing out problems.",
                "Make someone else smile.",
                "VOLUNTEER YOUR TIME AT LOCAL SCHOOLS",
                "RECOGNIZE THE HUMANITY OF OTHER PEOPLE, AND RESPECT THEIR DIGNITY",
                "USE LESS PAPER",
                "DRIVE LESS",
                "CONSERVE WATER",
                "DONATE TO CLEAN WATER CHARITIES",
                "BE GENEROUS",
                "Donate your time, skills or money to a cause",
                "Create a bee and bird friendly garden",
                "Tell someone they did a good job. Better yet, tell their boss!",
                "Don’t listen to, or participate in, gossip (on or offline)",
                "Give gifts without the expectation of anything in return",
                "Adopt a rescue pet",
                "Cook someone a hearty meal, either in person or leave it on their door step",
                "Decrease your ecological footprint",
                "Ask someone how they are, and give them your full attention – practice active listening",
                "Share your knowledge with someone",
                "Declutter, reuse, recycle or donate",
                "Smile and say hello to everyone you pass on the street",
                "Travel respectfully",
                "Please pick up your dog poop",
                "Give an elderly person some of your time – sit, talk, listen",
                "Sprinkle kindness like it’s confetti",
                "Share your own story of survival (because we’ve all fought our own battles that will strike a chord with someone else in the world).",
                "Don’t litter",
                "Treat everyone the way you would like to be treated. All of the time",
                "Live mindfully",
                "Donate blood or plasma",
                "Listen without passing judgement",
                "recognize your mistakes",
                "recognize your mistakes",
                "recognize your mistakes",
                "Express gratitude often. Personally",
                "Look after those you love and tell them that you love them often",
                "Give up your seat to someone on the bus or train",
                "Drive patiently. It’s not a race. And put away your phone. You don’t need it when you drive!",
                "Allow someone else their time to shine",
                "Learn more about other cultures, faiths, ideas, languages, people, history",
                "Be more considerate of others, whether you know them or not",
                "Mentor someone for free",
                "Write someone a thank you note (it could even be anonymous!)",
                "Don’t buy trashy magazines or click on click-bait headlines",
                "Help someone carry their shopping bags to the car",
                "Ditch fast fashion and embrace the slow fashion movement",
                "Spend less time online",
                "Step through life with honesty and integrity",
                "Read and tell positive stories, stories of hope, resilience and love",
                "Focus on the positive",
                "Spend ‘unplugged’ time with your kids. Give them 100% of your attention",
                "Give hugs",
                "Instead of driving, walk, ride or catch the bus",
                "Be a positive role model to kids / people younger than you",
                "Decrease your use of plastic",
                "Do what you love. That alone will inspire others.",
                "Adopt a rescue.",
                "Reconsider your consumption.",
                "Share a meal.",
                "Clean our space.",
                "Get involved.",
                "Give alms.",
                "Travel wisely.",
                "Check your community.",
                "Plant a (bee-friendly) garden.",
                "Give. Stuff. Away.",
                " Turn the TV off.",
                "Make art.",
                "Act locally.",
                "Put our money where our mouths are.",
                "Breathe it all in, love it all out.",
                "Remember the concept of ahimsa.",
                "Reconnect with old friends.",
                "Make one day in your week a completely offline one.",
                " Check our privilege.",
                "Be honest when it’s painful to be honest.",
                "Every day you wake up, be grateful.",
                "Live by the rule of “seven generation sustainability”.",
                "Study the seasons.",
                "If you buy something from a charity shop, pay double.",
                " Carry stress balls to squeeze when you feel under pressure.",
                "Buy your electricity from a supplier who uses only sustainable resources.",
                "Pay compliments.",
                "Swich off your mobile phone before going into the cinema or theatre.",
                "Tell someone their label's sticking out. Especially if you don't know them.",
                "Stop yourself saying 'I'.",
                "Bring birds into your life; get a bird-table, and make sure your cat has a bell around its neck.",
                "Join a union.",
                "Don't push.",
                "o out, don't stay in.",
                "Write down the number of mistakes you make in one day, and aim to double it. It's the only way to learn.",
                "Ditch the gym and join a team instead.",
                "Paint the outside of your house for the pleasure of those walking past (not just the inside for you).",
                "Take responsibility for your problems; don't blame others.",
                "Use small local shops.",
                "Say yes.",
                "Say yes.",
                "Say yes.",
                "Don't backstab: be honest, but not bitchy, with your colleagues instead.",
                "Go to non-Premier League football matches and show your support.",
                "Learn a new language.",
                "Do at least one cultural thing a week.",
                "Wear bright clothes once a week. It will cheer everyone up.",
                "Walk up escalators.",
                "Walk.",
                "Walk.",
                "If you have the choice, travel by train, not plane.",
                " Relax.",
                "Encourage children to become leaders. It will teach them to care for others.",
                "Telephone someone you haven't seen for five years.",
                "Buy two copies of the Guardian and give one to a non-Guardian-reading friend.",
                "Have your ticket ready at the barrier.",
                "Get email. Who'd have thought technology would bring us together?",
                "Read your newspaper's international pages.",
                "Laugh at yourself.",
                "Don't talk in the cinema.",
                "Dog owners: pick up their dirt. It may be disgusting, but think of the children.",
                "Write letters of complaint.",
                "Carry mints and go to the dentist; don't inflict bad breath on anyone.",
                "Write thank-you letters.",
                "Eat together, and not in front of the telly.",
                "Learn jokes. Start by memorising Tell Us A Joke, every Saturday right here in Guardian Weekend.",
                "Ring your parents more often.",
                "Don't shout at children. Especially not your own.",
                "Take a first-aid course.",
                "Don't cheat.",
                "Make hay, not war.",
                "Make hay, not war.",
                "Make hay, not war.",
                "Make hay, not war.",
                "Make hay, not war.",
                "Make hay, not war.",
                "Make hay, not war.",
                "Make hay, not war.",
                "Write to elderly relatives.",
                "Get rid of all the clutter in your workplace. And at home, too.",
                "Sit up.",
                "Sit up.",
                "Sit up.",
                "Sit up.",
                "Buy the Big Issue, but don't just give the seller money - stop for a chat.",
                "Tip.",
                "Get more sleep, and don't drive when you're tired.",
                "Keep a bowl of fruit on your desk at work.",
                "Take time off when you're ill.",
                "Find out the names of the security guards, cleaners and canteen staff at your place of work. And use them.",
                "If you see someone lost, show them the way.",
                "Fill the world with love, laughter and joy. Go on. It's our millennium.",
               "Plant at least one tree.",
                "Take care of your own trash",
                "Avoid waste.",
                "Think and rethink before you buy",
                "Think and rethink before you buy",
                "Think and rethink before you buy",
                "Think and rethink before you buy",
                "Think and rethink before you buy",
                "Take care of people and animals",
                "Take care of people and animals",
                "Take care of where you live."


        };

        String[] frasesReflexcao=
        {
                "All your things be done with love.  \n 1 Corinthians 16:14",
                "And above all this, put on love, which is the bond of perfection. \n Colossenses 3:14",
                "And now these three remain: faith, hope and love. But the greatest of these is love. \n 1 Corinthians 13:13",
                "Do everything in love. \n 1 Corinthians 16:14",
                "Be completely humble and gentle; be patient, bearing with one another in love. \n Ephesians 4:2",
                "Above all, love each other deeply, because love covers over a multitude of sins. \n 1 Peter 4:8 ",
                "Hatred stirs up conflict, but love covers over all wrongs. \n Proverbs 10:12",
                "Whoever does not love does not know God, because God is love. \n 1 John 4:8",
                "Love must be sincere. Hate what is evil; cling to what is good. \n Romans 12:9",
                "A friend loves at all times, and a brother is born for adversity. \n Proverbs 17:17",
                "Do to others as you would have them do to you. \n Luke 6:31",
                "I thank my God every time I think of you. \n Philippians 1:3",
                "Therefore a man shall leave his father and his mother and hold fast to his wife, and they shall become one flesh. \n Genesis 2:24",
                "Therefore what God has joined together, let no one separate. \n Mark 10:9",
                "Be kind to each other, tenderhearted, forgiving one another, just as God through Christ has forgiven you. \n Ephesians 4:32",
                "I am my beloved’s, and my beloved is mine. \n Song of Solomon 2:16",
                "Many waters cannot quench love; rivers cannot wash it away. \n Song of Solomon 8:7",
                "I have found the one whom my soul loves. \n Song of Solomon 3:4",
                "This is my commandment, that you love one another as I have loved you. \n John 15:12",
                "God has poured out his love into our hearts. \n Romans 5:5",
                "Love yesterday, today and forever. \n Jeremiah 31:3",
                "I hold you in my heart, for we have shared together God’s blessings. \n Philippians 1:7",
                "Through love serve one another.\n Galatians 5:13",
                "Above all things have intense and unfailing love for one another. \n Romans 12:10",
                "So she became his wife, and he loved her. \n Genesis 24:64",
                "A cord of three strands is not easily broken. \n Ecclesiastes 4:9-12",
                "This is my commandment, that you love one another as I have loved you. \n John 15:12",
                "Do not neglect to do good and to share what you have, for such sacrifices are pleasing to God. \n Hebrews 13:16 ",
                "Let each of you look not only to his own interests, but also to the interests of others. \n Philippians 2:4",
                "Bear one another's burdens, and so fulfill the law of Christ. \n Galatians 6:2",
                "Whoever is generous to the poor lends to the Lord, and he will repay him for his deed. \n Proverbs 19:17",
                "This is my commandment, that you love one another as I have loved you. \n John 15:12 ",
                "We who are strong have an obligation to bear with the failings of the weak, and not to please ourselves. \n Romans 15:1 ",
                "In the same way, let your light shine before others, so that they may see your good works and give glory to your Father who is in heaven. \n Matthew 5:16",
                "Give to the one who begs from you, and do not refuse the one who would borrow from you. \n Matthew 5:42",
                "Contribute to the needs of the saints and seek to show hospitality. \n Romans 12:13",
                "Do not withhold good from those to whom it is due, when it is in your power to do it. \n Proverbs 3:27",
                "For God is not unjust so as to overlook your work and the love that you have shown for his name in serving the saints, as you still do. \n Hebrews 6:10",
                "Greater love has no one than this, that someone lay down his life for his friends. \n John 15:13",
                "Whoever gives to the poor will not want, but he who hides his eyes will get many a curse. \n Proverbs 28:27",
                "And the King will answer them, ‘Truly, I say to you, as you did it to one of the least of these my brothers, you did it to me.’ \n Matthew 25:40",
                "Heal the sick, raise the dead, cleanse lepers, cast out demons. You received without paying; give without pay. \n Matthew 10:8",
                "Whoever oppresses a poor man insults his Maker, but he who is generous to the needy honors him. \n Proverbs 14:31 ",
                "If you pour yourself out for the hungry and satisfy the desire of the afflicted, then shall your light rise in the darkness and your gloom be as the noonday. \n Isaiah 58:10",
                "Whoever brings blessing will be enriched, and one who waters will himself be watered. \n Proverbs 11:25",
                "Learn to do good; seek justice, correct oppression; bring justice to the fatherless, plead the widow's cause. \n Isaiah 1:17",
                "If any of you lacks wisdom, let him ask God, who gives generously to all without reproach, and it will be given him. \n James 1:5",
                "Whoever closes his ear to the cry of the poor will himself call out and not be answered. \n Proverbs 21:13",
                "And let us not grow weary of doing good, for in due season we will reap, if we do not give up. \n Galatians 6:9 ",
                "A righteous man knows the rights of the poor; a wicked man does not understand such knowledge. \n Proverbs 29:7 ",
                "For God so loved the world, that he gave his only Son, that whoever believes in him should not perish but have eternal life. \n John 3:16",
                "For even when we were with you, we would give you this command: If anyone is not willing to work, let him not eat. \n 2 Thessalonians 3:10",
                "Open your mouth, judge righteously, defend the rights of the poor and needy. \n Proverbs 31:9",
                "Whoever despises his neighbor is a sinner, but blessed is he who is generous to the poor. \n Proverbs 14:21 ",
                "Now there was in Joppa a disciple named Tabitha, which, translated, means Dorcas. She was full of good works and acts of charity. \n Acts 9:36",
                "Therefore encourage one another and build one another up, just as you are doing. \n 1 Thessalonians 5:11 ",
                "Father of the fatherless and protector of widows is God in his holy habitation. \n Psalm 68:5  ",
                "As each has received a gift, use it to serve one another, as good stewards of God's varied grace: \n 1 Peter 4:10",
                "Love one another with brotherly affection. Outdo one another in showing honor. \n Romans 12:10",
                "The greatest among you shall be your servant. \n Matthew 23:11 ",
                "For even the Son of Man came not to be served but to serve, and to give his life as a ransom for many. \n Mark 10:45",
                "But give as alms those things that are within, and behold, everything is clean for you. \n Luke 11:41",
                "Be kind to one another, tenderhearted, forgiving one another, as God in Christ forgave you. \n Ephesians 4:32",
                "But seek first the kingdom of God and his righteousness, and all these things will be added to you. \n Matthew 6:33",
                "Therefore my heart is glad, and my glory rejoices; my flesh also will rest in hope. \n  Psalm 16:9",
                "You are my hiding place and my shield; I hope in Your word. \n Psalm 119:114",
                "O Israel, hope in the LORD; for with the LORD there is mercy, and with Him is abundant redemption. \n Psalm 130:7",
                " The LORD takes pleasure in those who fear Him, in those who hope in His mercy. \n Psalm 147:11",
                "For surely there is a hereafter, and your hope will not be cut off. \n Proverbs 23:18",
                "Blessed is the man who trusts in the LORD, and whose hope is the LORD. \n Jeremiah 17:7",
                "The LORD is my portion,’ says my soul, ‘therefore I hope in Him! \n Lamentations 3:24",
                "Rejoicing in hope, patient in tribulation, continuing steadfastly in prayer. \n Romans 12:12",
                "In hope of eternal life which God, who cannot lie, promised before time began. \n Titus 1:2",
                "Looking for the blessed hope and glorious appearing of our great God and Savior Jesus Christ. \n Titus 2:13",
                "And everyone who has this hope in Him purifies himself, just as He is pure. \n 1 John 3:3",
                "When a man’s ways please the LORD, He makes even his enemies to be at peace with him. \n Proverbs 16:7",
                "You will keep him in perfect peace, whose mind is stayed on You, because he trusts in You. \n Isaiah 26:3",
                "The LORD lift up His countenance upon you, and give you peace. \n Numbers 6:26",
                "He has redeemed my soul in peace from the battle that was against me, for there were many against me. \n Psalm 55:18",
                "Mercy and truth have met together; righteousness and peace have kissed. \n Psalm 85:10",
                "Great peace have those who love Your law, and nothing causes them to stumble. \n Psalm 119:165",
                "For length of days and long life and peace they will add to you. \n Proverbs 3:2",
                "All your children shall be taught by the LORD, and great shall be the peace of your children. \n Isaiah 54:13",
                "Therefore, having been justified by faith, we have peace with God through our Lord Jesus Christ. \n Romans 5:1",
                "For to be carnally minded is death, but to be spiritually minded is life and peace. \n Romans 8:6",
                "For the kingdom of God is not eating and drinking, but righteousness and peace and joy in the Holy Spirit. \n Romans 14:17 ",
                "For God is not the author of confusion but of peace, as in all the churches of the saints. \n 1 Corinthians 14:33",
                "But the fruit of the Spirit is love, joy, peace, longsuffering, kindness, goodness, faithfulness. \n Galatians 5:22",
                "Endeavoring to keep the unity of the Spirit in the bond of peace. \n Ephesians 4:3",
                "And having shod your feet with the preparation of the gospel of peace. \n Ephesians 6:15",
                "Now the fruit of righteousness is sown in peace by those who make peace. \n James 3:18",
                "Now may the Lord of peace Himself give you peace always in every way. The Lord be with you all. \n 2 Thessalonians 3:16"

        };



        metodo6();
        Handler handler = new Handler();
        long delay = 300;

        handler.postDelayed(new Runnable() {
            public void run() {
                // código a ser executado após o tempo de delay
                metodo5();
            }
        }, delay);


        //Gerar número aleatório com o Random
        int numero = new Random().nextInt(frasesMotiva.length);


        //Relacionar a frase do array à variável texto
        motiva.setText( frasesMotiva[numero] );

        int numero1 = new Random().nextInt(frasesObjetivo.length);


        //Relacionar a frase do array à variável texto
        objetivo.setText( frasesObjetivo[numero1] );

        int numero2 = new Random().nextInt(frasesReflexcao.length);


        //Relacionar a frase do array à variável texto
        reflexcao.setText( frasesReflexcao[numero2] );


    }




    public void btnporxima1(View view)
    {
        proxima();
    }

    private void proxima()
    {

        metodo2();
        Handler handler = new Handler();
        long delay = 300;

        handler.postDelayed(new Runnable() {
            public void run() {
                // código a ser executado após o tempo de delay
                metodo1();
            }
        }, delay);

        Intent intent = new Intent(getApplicationContext(),Anuncios.class);
        startActivity(intent);

    }

    public void metodo1()  {
        // Thread.sleep(1500);
        suporteme.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[1]));
    }
    public void metodo2()  {
        // Thread.sleep(1500);
        suporteme.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[0]));
    }

    public void metodo3()  {
        // Thread.sleep(1500);
        voltar.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[1]));
    }
    public void metodo4()  {
        // Thread.sleep(1500);
        voltar.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[0]));
    }

    public void metodo5()  {
        // Thread.sleep(1500);
        btntarefa.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[1]));
    }
    public void metodo6()  {
        // Thread.sleep(1500);
        btntarefa.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[0]));
    }



    public void btnvoltar(View view)
    {
        voltar();
    }

    private void voltar()
    {

        metodo4();
        Handler handler = new Handler();
        long delay = 300;

        handler.postDelayed(new Runnable() {
            public void run() {
                // código a ser executado após o tempo de delay
                metodo3();
            }
        }, delay);

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }

/*

//trabalhando com pegar a data do dia e a hora
    public Date datadehoje() {

        Date dt = new Date();

        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");


        a = formato.format(dt);
                //formato.format(nova);
       b = formato.format(dt);

        if (a == b) {

            nova = dt;
            motiva.setText(nova.toString());
        }
        else
        {
            //motiva.setText("Não ha motivação");
        }

        return nova;
    }*/


}