import requests
from fake_useragent import UserAgent
from lxml import etree
import time
url = 'https://www.bbc.com/'
headers = {'User-Agent':UserAgent().chrome}
response = requests.get(url,headers=headers)
time.sleep(2)
html = etree.HTML(response.text)
href = html.xpath('//ul[@class="ws-languages__list"]/li[5]/a/@href')
href_t = 'https://www.bbc.com' + href[0]
resp = requests.get(href_t,headers=headers)
html = etree.HTML(resp.text)
title_url = html.xpath('//div[@class="bbc-1sk5sm2 e19k1v2h0"]/h3/a/@href')
title = html.xpath('//div[@class="bbc-1sk5sm2 e19k1v2h0"]/h3/a/span/text()')
time_t = html.xpath('//div[@class="bbc-1sk5sm2 e19k1v2h0"]/time/text()')
for i in range(0,40):
    url = 'https://www.bbc.com' + title_url[i]
    resp = requests.get(url, headers=headers)
    html = etree.HTML(resp.text)
    author = ''.join(html.xpath('//div[@class="e1j2237y3 bbc-irdbz7 e57qer20"]/main/div/ul/li/text()'))
    if not author:
        author = ''.join(html.xpath('//div[@class="e1j2237y3 bbc-irdbz7 e57qer20"]/main/div/p/text()'))
    time.sleep(2)
    print('[title]:', title[i], '\n[Title_Url]:', url, '\n[Date]:', time_t[i], '\n[author]:', author)

    with open('新闻-result.txt', mode='a', encoding='utf8') as f:
        f.write('[Title]:{}\n'.format(title[i]))
        f.write('[Title_Url]:{}\n'.format(url))
        f.write('[Date]:{}\n'.format(time_t[i]))
        f.write('[author]:{}\n'.format(author))
        f.write('----------\n')













