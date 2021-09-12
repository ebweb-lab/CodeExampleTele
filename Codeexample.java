public class IncomingCallListener extends BroadcastReceiver
    {
        private Context mContext;
        private static final String TAG = "CustomBroadcastReceiver";
         TelephonyManager telephony;
         CustomPhoneStateListener customPhoneListener ;
        @Override
        public void onReceive(Context context, Intent intent) 
        {
            mContext = context;
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String state = extras.getString(TelephonyManager.EXTRA_STATE);
                Log.w("DEBUG", state);

                    telephony = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
                    customPhoneListener = new   CustomPhoneStateListener();
                    telephony.listen(customPhoneListener,   PhoneStateListener.LISTEN_CALL_STATE);
                    Bundle bundle = intent.getExtras();
                    String phoneNr= bundle.getString("incoming_number");


            }


        }
        public class CustomPhoneStateListener extends PhoneStateListener
        {
            private static final String TAG = "CustomPhoneStateListener";
            Handler handler=new Handler();
            @Override
            public void onCallStateChanged(int state, String incomingNumber) 
            {
                switch (state) 
                {
                case TelephonyManager.CALL_STATE_RINGING:
                    if(!incomingNumber.equalsIgnoreCase(""))
                    {
                        //YOUR CODE HERE

                    }
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    //YOUR CODE HERE

                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    //YOUR CODE HERE
                    break;
                default:
                    break;
                }
                super.onCallStateChanged(state, incomingNumber);
                telephony.listen(customPhoneListener, PhoneStateListener.LISTEN_NONE);
            }


        }       
    }
