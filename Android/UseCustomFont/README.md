## Use Custom Font

- 1������Ŀ�е�assetsĿ¼������fontsĿ¼�����������ļ�����Ŀ¼��
- 2��������塣
		Typeface tfMinecraft = Typeface.createFromAsset(getAssets(), "fonts/minecraft.ttf");
- 3��Ӧ�����塣
    TextView tvTitle = (TextView)findViewById(R.id.tvTitle);
    tvTitle.setTypeface(tfMinecraft);
